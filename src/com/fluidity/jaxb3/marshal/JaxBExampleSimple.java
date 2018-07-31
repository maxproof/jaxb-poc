package com.fluidity.jaxb3.marshal;

import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.fluidity.jaxb3.business.Country;

/**
 * Simple example of usage of jaxb marshaling functionalities
 */
public class JaxBExampleSimple
{

    public static void main( String[] args )
    {
        try
        {

            /* init very simple data to marshal */
            Country spain = new Country();
            spain.setName( "Spain" );
            spain.setCapital( "Madrid" );
            spain.setContinent( "Europe" );
            spain.setFoundation( LocalDate.of( 1469, 10, 19 ) );

            
            spain.setPopulation( 45000000 );

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Country.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( spain, new File( "country.xml" ) );
            jaxbMarshaller.marshal( spain, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
