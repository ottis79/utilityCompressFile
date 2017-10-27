package my.compressDecompressGZip;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.Duration;

import org.xml.sax.SAXException;


public interface PmCollectionGenerator {

 
    /**
     * This method creates the xml file with data stored in the PmCollectionGenerator. If an error occurs an exception is thrown.
     *
     * @param xmlFile
     *            : file to create
     * @return file properties
     */
    FileProperties createXmlFile(final Path xmlFile) throws Exception;

    /**
     * This method creates the xml compressor file with data stored in the PmCollectionGenerator. If an error occurs an exception is thrown.
     *
     * @param xmlFile
     *            : file to create
     * @return file properties
     */
    FileProperties createXmlCompressFile(final File xmlFile) throws Exception;

}
