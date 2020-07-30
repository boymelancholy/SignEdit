package mcbe.boymelancholy.signedit.forms;

import cn.nukkit.Player;
import itsu.mcbe.form.base.SimpleForm;
import itsu.mcbe.form.element.Button;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.utils.FormMaker;
import mcbe.boymelancholy.signedit.utils.Memory;

import java.util.ArrayList;

public class DeleteForm {
    public SimpleForm getForm(Player player) {
        Memory memory = SignEdit.getInstance().getMemory();
        ArrayList<String> copyKeys = new ArrayList<>((memory.getCopiedMemory(player)).keySet());
        SimpleForm form = new SimpleForm() {
            @Override
            public void onEnter(Player player, int index) {
                if (index == -1) {
                    player.sendMessage("> 中断しました");
                    return;
                }
                String key = copyKeys.get(index);
                memory.removeCopiedMemory(player, key);
                player.sendMessage("> 削除しました");
            }
        };

        form.setId(FormMaker.formCount++);
        form.setTitle("DELETE");
        form.setContent("削除するデータを選択してください");

        for(String key : (memory.getCopiedMemory(player)).keySet()) {
            form.addButton(new Button().setText(key));
        }

        return form;
    }
}
