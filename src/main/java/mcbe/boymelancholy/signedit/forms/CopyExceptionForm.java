package mcbe.boymelancholy.signedit.forms;

import cn.nukkit.Player;
import itsu.mcbe.form.base.ModalForm;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.utils.FormMaker;

public class CopyExceptionForm {
    public ModalForm getForm(Player player) {
        FormMaker maker = SignEdit.getInstance().getMemory().getMakerMemory(player);

        ModalForm form = new ModalForm() {
            @Override
            public void onButton1Click(Player player) {
                maker.sendForm(FormMaker.copy);
            }

            @Override
            public void onButton2Click(Player player) {
                player.sendMessage("> 処理を中断しました");
            }
        };

        form.setId(FormMaker.formCount++);
        form.setTitle("ERROR");
        form.setContent("すでに存在するエイリアス名は使えません");
        form.setButton1Text("再入力する").setButton2Text("中断する");

        return form;
    }
}
