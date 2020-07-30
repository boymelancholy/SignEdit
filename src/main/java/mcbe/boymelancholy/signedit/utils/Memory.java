package mcbe.boymelancholy.signedit.utils;

import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;

import java.util.HashMap;

public class Memory {

    private final HashMap<Player, FormMaker> makerMemory;
    private final HashMap<Player, BlockEntitySign> signMemory;
    private final HashMap<Player, HashMap<String, String[]>> copiedMemory;

    public Memory() {
        this.makerMemory = new HashMap<Player, FormMaker>();
        this.signMemory = new HashMap<Player, BlockEntitySign>();
        this.copiedMemory = new HashMap<Player, HashMap<String, String[]>>();
    }

    public FormMaker getMakerMemory(Player player) {
        return this.makerMemory.get(player);
    }

    public BlockEntitySign getSignMemory(Player player) {
        return this.signMemory.get(player);
    }

    public HashMap<String, String[]> getCopiedMemory(Player player) {
        return this.copiedMemory.get(player);
    }

    public String[] getCopiedMemory(Player player, String tag) {
        HashMap<String, String[]> map = this.copiedMemory.get(player);
        return map.containsKey(tag) ? map.get(tag) : new String[] {"", "", "", ""};
    }

    public void setMakerMemory(Player player, FormMaker maker) {
        this.makerMemory.put(player, maker);
    }

    public void setSignMemory(Player player, BlockEntitySign sign) {
        this.signMemory.put(player, sign);
    }

    public void setCopiedMemory(Player player, String tag, String[] texts) {
        HashMap<String, String[]> map = this.copiedMemory.get(player);
        map.put(tag, texts);
        this.copiedMemory.replace(player, map);
    }

    public boolean hasCopiedMemory(Player player) {
        return this.copiedMemory.containsKey(player);
    }

    public boolean hasCopiedMemory(Player player, String tag) {
        if (!this.copiedMemory.containsKey(player)) return false;
        HashMap<String, String[]> map = this.copiedMemory.get(player);
        return map.containsKey(tag);
    }

    public void initCopiedMemory(Player player) {
        if (this.copiedMemory.containsKey(player)) return;
        this.copiedMemory.put(player, new HashMap<String, String[]>());
    }

    public void removeCopiedMemory(Player player, String tag) {
        if (!this.copiedMemory.containsKey(player)) return;
        (this.copiedMemory.get(player)).remove(tag);
    }
}
