package mcbe.boymelancholy.signedit;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockSignPost;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemFeather;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
import mcbe.boymelancholy.signedit.utils.FormMaker;
import mcbe.boymelancholy.signedit.utils.Memory;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Item item = event.getItem();
        if (block instanceof BlockSignPost && item instanceof ItemFeather) {
            Memory memory = SignEdit.getInstance().getMemory();
            Level level = player.getLevel();
            Vector3 pos = new Vector3(block.x, block.y, block.z);
            BlockEntity entitySign = level.getBlockEntity(pos);
            if (! (entitySign instanceof BlockEntitySign) ) {
                return;
            }

            FormMaker maker = new FormMaker(player);

            memory.setSignMemory(player, ((BlockEntitySign) entitySign));
            memory.setMakerMemory(player, maker);
            maker.sendForm(FormMaker.call);
        }
    }
}
