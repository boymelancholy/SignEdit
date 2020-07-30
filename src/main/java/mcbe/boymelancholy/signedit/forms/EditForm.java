package mcbe.boymelancholy.signedit.forms;

import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;
import itsu.mcbe.form.base.CustomForm;
import itsu.mcbe.form.element.Input;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.utils.FormMaker;
import mcbe.boymelancholy.signedit.utils.Memory;

import java.util.List;

public class EditForm {

    public CustomForm getForm(Player player) {
        Memory memory = SignEdit.getInstance().getMemory();
        BlockEntitySign sign = memory.getSignMemory(player);

        CustomForm form = new CustomForm() {
            @Override
            public void onEnter(Player player, List<Object> response) {
                String line1 = (String) response.get(0);
                String line2 = (String) response.get(1);
                String line3 = (String) response.get(2);
                String line4 = (String) response.get(3);
                String[] lines = {
                    line1.substring(1, line1.length() - 1),
                    line2.substring(1, line2.length() - 1),
                    line3.substring(1, line3.length() - 1),
                    line4.substring(1, line4.length() - 2)
                };

                sign.setText(lines[0], lines[1], lines[2], lines[3]);
                sign.saveNBT();

                player.sendMessage("> 書き換えが終わりました");
            }
        };

        String[] lines = sign.getText();

        form.setId(FormMaker.formCount++);
        form.setTitle("EDIT");
        form.addFormElement(new Input().setText("1行目:").setDefaultText(lines[0]));
        form.addFormElement(new Input().setText("2行目:").setDefaultText(lines[1]));
        form.addFormElement(new Input().setText("3行目:").setDefaultText(lines[2]));
        form.addFormElement(new Input().setText("4行目:").setDefaultText(lines[3]));

        return form;
    }
}
