package mcbe.boymelancholy.signedit.forms;

import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;
import itsu.mcbe.form.base.SimpleForm;
import itsu.mcbe.form.element.Button;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.utils.FormMaker;
import mcbe.boymelancholy.signedit.utils.Memory;

import java.util.ArrayList;

public class PasteForm {

    public SimpleForm getForm(Player player) {
        Memory memory = SignEdit.getInstance().getMemory();
        BlockEntitySign sign = memory.getSignMemory(player);
        ArrayList<String> copyKeys = new ArrayList<>((memory.getCopiedMemory(player)).keySet());
        SimpleForm form = new SimpleForm() {
            @Override
            public void onEnter(Player player, int index) {
                if (index == -1) {
                    return;
                }
                String key = copyKeys.get(index);
                String[] lines = memory.getCopiedMemory(player, key);
                sign.setText(lines);
                sign.saveNBT();
                player.sendMessage("> 貼り付けました");
            }
        };

        form.setId(FormMaker.formCount++);
        form.setTitle("PASTE");
        form.setContent("貼り付けるデータを選択してください");

        for(String key : (memory.getCopiedMemory(player)).keySet()) {
            form.addButton(new Button().setText(key));
        }

        return form;
    }
}
