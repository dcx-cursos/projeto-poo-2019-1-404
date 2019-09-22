package br.com.ufpb.POO.SorteReves;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ManipuladoTextCartas {

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./Properties/DadosCartas.properties");
        props.load(file);
        return props;
 
    }

    public static int getValorCarta(int idCarta) throws IOException
    {
        Properties prop = getProp();
        return Integer.parseInt(prop.getProperty("valor."+idCarta));
    }

    public static String getStringCarta(int idCarta) throws IOException
    {
        Properties prop = getProp();
        return prop.getProperty("string."+idCarta);
    }

}
