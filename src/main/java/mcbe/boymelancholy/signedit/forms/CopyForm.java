package mcbe.boymelancholy.signedit.forms;

import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;
import itsu.mcbe.form.base.CustomForm;
import itsu.mcbe.form.element.Input;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.utils.FormMaker;
import mcbe.boymelancholy.signedit.utils.Memory;

import java.util.List;

public class CopyForm {

    public CustomForm getForm(Player player) {
        Memory memory = SignEdit.getInstance().getMemory();
        BlockEntitySign sign = memory.getSignMemory(player);

        CustomForm form = new CustomForm() {
            @Override
            public void onEnter(Player player, List<Object> response) {
                String aliasRaw = ((String) response.get(0));
                String alias = aliasRaw.substring(1, aliasRaw.length() - 2);
                String[] lines = sign.getText();

                if (memory.hasCopiedMemory(player, alias)) {
                    FormMaker maker = memory.getMakerMemory(player);
                    maker.sendForm(FormMaker.error);
                } else {
                    memory.setCopiedMemory(player, alias, lines);
                    player.sendMessage("> コピーが終わりました");
                }
            }
        };
        form.setId(FormMaker.formCount++);
        form.setTitle("COPY");
        form.addFormElement(new Input().setText("保存するエイリアス名を入力してください: "));

        return form;
    }
}
