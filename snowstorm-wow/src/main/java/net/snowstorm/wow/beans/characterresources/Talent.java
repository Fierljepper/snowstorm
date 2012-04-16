package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/16/12 Time: 11:46 PM To change this template use File | Settings |
* File Templates.
*/
public class Talent extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("2c0b397c-53c4-46cb-be13-8e29e65eb2b6");

    private boolean selected;
    private String name;
    private String icon;
    private String build;
    private Collection<Tree> trees;
    private Glyphs glyphs;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(final String icon) {
        this.icon = icon;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(final String build) {
        this.build = build;
    }

    public Collection<Tree> getTrees() {
        return trees;
    }

    public void setTrees(final Collection<Tree> trees) {
        this.trees = trees;
    }

    public Glyphs getGlyphs() {
        return glyphs;
    }

    public void setGlyphs(final Glyphs glyphs) {
        this.glyphs = glyphs;
    }

    @Override
    public String toString(){
        return getName();
    }
}
