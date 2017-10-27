package my.compressDecompressGZip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * This class create a PmCollection file with the data passed via its set-method.
 */
public class PmCollectionGeneratorImpl implements PmCollectionGenerator {
    
    private static final String EXTENSION_COMPRESS_FILE = ".gz";

   
    @Override
    public FileProperties createXmlFile(final Path xmlFile) throws Exception  {
        // Get the JAXB Marshaller for the specified schema
        Marshaller marshaller = null;

        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance();
            marshaller = jaxbContext.createMarshaller();
        } catch (final Exception e) {
            throw new Exception("Error getting marshaller for MeasCollecFile");
        }

        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,"" );
            marshaller.marshal("", xmlFile.toFile());
        } catch (final Exception e) {
            throw new Exception("Error xml");
        }
        return new FileProperties(xmlFile.toFile().getName(), xmlFile.toFile().length(), xmlFile.toAbsolutePath().toString());
    }

    @Override
    public FileProperties createXmlCompressFile(final File xmlFile) throws Exception  {
        GZIPOutputStream gzipOS = null;
        Marshaller marshaller;
        StringWriter sw;
        FileOutputStream fos;
        File tmpFile;
        try {
            sw = new StringWriter();
            final JAXBContext jaxbContext = JAXBContext.newInstance();
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");
            marshaller.marshal("", sw);
            fos = new FileOutputStream(xmlFile + EXTENSION_COMPRESS_FILE);
            gzipOS = new GZIPOutputStream(fos);
            gzipOS.write(sw.toString().getBytes());
            tmpFile = new File(xmlFile.getPath() + EXTENSION_COMPRESS_FILE);
            gzipOS.close();
            fos.close();
        } catch (final Exception e) {
            throw new Exception("Error getting marshaller for MeasCollecFile");
        } finally {
            if (gzipOS != null) {
                try {
                    gzipOS.finish();
                    gzipOS.close();
                } catch (final IOException e) {
                    throw new Exception("Error getting marshaller for MeasCollecFile");
                }
            }
        }
        return new FileProperties(xmlFile.getName() + EXTENSION_COMPRESS_FILE, tmpFile.length(), xmlFile.getAbsolutePath() + EXTENSION_COMPRESS_FILE);
    }
}
