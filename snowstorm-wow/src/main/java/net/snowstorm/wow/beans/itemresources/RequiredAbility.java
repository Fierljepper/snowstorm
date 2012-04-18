package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 11:19 AM To change this template use File | Settings
 * | File Templates.
 */
public class RequiredAbility extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("b4ec0b25-dada-40ec-91e1-49cc2d7e78d9");

    private int spellId;
    private String name;
    private String description;

    public int getSpellId() {
        return spellId;
    }

    public void setSpellId(final int spellId) {
        this.spellId = spellId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
