package javaapplication1;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublishSample implements MqttCallback {

MqttClient client;
Test userInterface;

    public MqttPublishSample(Test t) {
    	userInterface = t;
    }

    /*public static void main(String[] args) {
        new MqttPublishSample().doDemo();
    }*/
    
    public void subscribe(String serverURI, String clientId, String topic) {
    	try {
            client = new MqttClient(serverURI, clientId);
            client.connect();
            client.setCallback(this);
            client.subscribe(topic);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void doDemo() {
    	subscribe("tcp://206.189.191.14", "Receiving", "/esp/temp");
    }
    
    public void publish(String serverURI, String clientId, String topic, String message) {
	     class Write implements Runnable {
	    	 String serverURI, clientId, topic, message;
	         
	         Write(String serverURI, String clientId,
	        		 String topic, String message) {
	             this.serverURI = serverURI;
	             this.clientId = clientId;
	             this.topic = topic;
	             this.message = message;
	         }

	         public void run() {
	        	try {
    	     		MqttClient c2 = new MqttClient(serverURI, clientId);
    	    		c2.connect();
    	    		//c2.setCallback(this);
    	            MqttMessage mqttmsg = new MqttMessage();
    	            mqttmsg.setPayload(message.getBytes());
    	            c2.publish(topic, mqttmsg);
	        	} catch (MqttException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	         }
	     }
        //client = new MqttClient(serverURI, clientId);
        //client.connect();
        //client.setCallback(this);
	     
	     Write w = new Write(serverURI, clientId, topic, message);
	     new Thread(w).start();
    }


    @Override   
    public void connectionLost(Throwable cause) {
    // TODO Auto-generated method stub

    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
    	String str = new String(mm.getPayload());
        System.out.println(str);
        userInterface.SubOutputWrite(str);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}