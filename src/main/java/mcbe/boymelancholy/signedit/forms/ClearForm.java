package mcbe.boymelancholy.signedit.forms;

import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;
import itsu.mcbe.form.base.ModalForm;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.utils.FormMaker;
import mcbe.boymelancholy.signedit.utils.Memory;

public class ClearForm {

    public ModalForm getForm(Player player) {
        Memory memory = SignEdit.getInstance().getMemory();
        BlockEntitySign sign = memory.getSignMemory(player);

        ModalForm form = new ModalForm() {
            @Override
            public void onButton1Click(Player player) {
                sign.setText("", "", "", "");
                sign.saveNBT();

                player.sendMessage("> 全削除しました");
            }

            @Override
            public void onButton2Click(Player player) {
                player.sendMessage("> 処理を中断しました");
            }
        };

        form.setId(FormMaker.formCount++);
        form.setTitle("CLEAR");
        form.setContent("この看板の文字を全削除しますか");
        form.setButton1Text("はい");
        form.setButton2Text("いいえ");

        return form;
    }
}
