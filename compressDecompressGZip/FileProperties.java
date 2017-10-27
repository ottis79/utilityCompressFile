package my.compressDecompressGZip;
/**
 * Utility class to manage file properties 
 *
 * Created by eottgen on 10/26/17.
 */
public class FileProperties {

    private String name;
    private long size;
    private String path;

    /**
     * Constuctor
     * @param name
     *            name of file
     * @param size
     *            size of file
     * @param path
     *            path of file
     */
    public FileProperties(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    /**
     * Get file name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set file name
     *
     * @param name name of file
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get file size
     *
     * @return size
     */
    public long getSize() {
        return size;
    }

    /**
     * Set file size
     *
     * @param size size of file
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * Get path file
     *
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Set path file
     *
     * @param path path of file
     */
    public void setPath(String path) {
        this.path = path;
    }
}