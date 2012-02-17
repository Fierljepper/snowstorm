package net.snowstorm.wow.beans;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/16/12 Time: 7:13 PM To change this template use File | Settings |
 * File Templates.
 */
public class Guild {
    
    private String name;
    private String realm;
    private int level;
    private int members;
    private int achievementPoints;
    private Emblem emblem;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(final String realm) {
        this.realm = realm;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(final int members) {
        this.members = members;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(final int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public Emblem getEmblem() {
        return emblem;
    }

    public void setEmblem(final Emblem emblem) {
        this.emblem = emblem;
    }

    public class Emblem{
        private int icon;
        private String iconColor;
        private int border;
        private String borderColor;
        private String backgroundColor;

        public int getIcon() {
            return icon;
        }

        public void setIcon(final int icon) {
            this.icon = icon;
        }

        public String getIconColor() {
            return iconColor;
        }

        public void setIconColor(final String iconColor) {
            this.iconColor = iconColor;
        }

        public int getBorder() {
            return border;
        }

        public void setBorder(final int border) {
            this.border = border;
        }

        public String getBorderColor() {
            return borderColor;
        }

        public void setBorderColor(final String borderColor) {
            this.borderColor = borderColor;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(final String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }
}
