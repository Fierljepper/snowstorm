package net.snowstorm.wow.beans;

import java.util.Collection;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/16/12 Time: 11:46 PM To change this template use File | Settings |
* File Templates.
*/
public class Talent {
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

    public class Tree {
        private String points;
        private int total;

        public String getPoints() {
            return points;
        }

        public void setPoints(final String points) {
            this.points = points;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(final int total) {
            this.total = total;
        }
    }


    public class Glyphs {
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

        public class Glyph {

            private int glyph;
            private int item;
            private String name;
            private String icon;

            public int getGlyph() {
                return glyph;
            }

            public void setGlyph(final int glyph) {
                this.glyph = glyph;
            }

            public int getItem() {
                return item;
            }

            public void setItem(final int item) {
                this.item = item;
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

        }
    }


}
