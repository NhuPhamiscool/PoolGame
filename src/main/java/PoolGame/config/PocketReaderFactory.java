package PoolGame.config;

/** Interface for building readers. */
public class PocketReaderFactory implements ReaderFactory {
    /**
     * Builds a PocketReader.
     * 
     * @return pocket reader.
     */
    public Reader buildReader() {
        return new PocketReader();
    };
}