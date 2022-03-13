package test;

import java.net.*; // Importación de DatagramPacket, DatagramSocket e InetAddress

import auxiliar.Utiles;



class TestNTP {
	


 	public static void main(String[] args) {

 		byte[] paquete_NTP_env = new byte[48];
 		
		paquete_NTP_env[0] = 35;
		String address = "130.206.3.166" ;
		byte[] paquete_NTP_rec = new byte[48];
		DatagramPacket recibo = new DatagramPacket(paquete_NTP_rec, paquete_NTP_rec.length);

		try{
		DatagramPacket envio = new DatagramPacket( paquete_NTP_env, paquete_NTP_env.length, InetAddress.getByName(address), 123);
		 
		 
		

		//DatagramPacket recibo = new DatagramPacket(paquete_NTP_rec, paquete_NTP_rec.length);

		DatagramSocket socket = new DatagramSocket(1025);	

		socket.send(envio);
		socket.receive(recibo);
		} catch (Exception e) { 


			}
		paquete_NTP_rec = recibo.getData();
		byte[] paquete= new byte[4];
		for (int i = 40; i < 44; i++){
            
			paquete[i-40] = paquete_NTP_rec[i];
        }
		
		long resultado = Utiles.de_Array4Bytes_a_Long(paquete);
		byte[] hms = Utiles.de_UTC_a_hms(resultado);
		System.out.println("La hora actual en GTM + 1 es = " + hms[0] + ":" + hms[1] + ":" + hms[2] );


 	}

}