package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 11:30 AM To change this template use File | Settings |
* File Templates.
*/
public class Glyphs extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("7f143d7b-2890-4eba-b248-195d7f705a90");

    private Collection<Glyph> prime;
    private Collection<Glyph> major;
    private Collection<Glyph> minor;

    public Collection<Glyph> getPrime() {
        return prime;
    }

    public void setPrime(final Collection<Glyph> prime) {
        this.prime = prime;
    }

    public Collection<Glyph> getMajor() {
        return major;
    }

    public void setMajor(final Collection<Glyph> major) {
        this.major = major;
    }

    public Collection<Glyph> getMinor() {
        return minor;
    }

    public void setMinor(final Collection<Glyph> minor) {
        this.minor = minor;
    }

}
