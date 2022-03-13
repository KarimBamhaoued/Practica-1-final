package auxiliar;

public class Utiles {
    

    /** Crea un long a partir de cuatro bytes en formato big endian */
    public static long de_Array4Bytes_a_Long(byte[] vector) {
        long result = 0;
        
        for (int i = 0; i < 4; i++){
            result = (result << 8) + (vector[i] & 0xFF);
        }
        
        return result;
    }

    /** Extrae de un long los cuatro bytes menos significativos */
    static public byte[] de_Long_a_Array4Bytes(long t) {
        byte [] vector = new byte[4];
        long aux;
        for (int i = 0; i < 4; i++) {
            aux = t >> (8*(3-i));
            vector[i] = (byte)(aux & 0xFF);
        }
        return vector;
    }

    /** Extrae de un long conteniendo tiempo UTC, las horas,
     minutos y segundos del
     * día, en un array de 3 bytes */
	public static byte[] de_UTC_a_hms(long t) {
		byte[] hms = new byte[3];
        hms[2] =   (byte) (t % 60);
        hms[1] = (byte) ((t % 3600) /60);
        hms[0] =   (byte) (  ((t+3600) %  86400  ) /3600);
        
        
		return hms;
 	}

}