package mcbe.boymelancholy.signedit.forms;

import cn.nukkit.Player;
import itsu.mcbe.form.base.SimpleForm;
import itsu.mcbe.form.element.Button;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.utils.FormMaker;

public class TopForm {

    public SimpleForm getForm(Player player) {
        SimpleForm form = new SimpleForm() {
            @Override
            public void onEnter(Player player, int index) {
                FormMaker maker = SignEdit.getInstance().getMemory().getMakerMemory(player);
                if (index == -1) {
                    return;
                }
                switch (index) {
                    case 0:
                        maker.sendForm(FormMaker.edit);
                        break;

                    case 1:
                        SignEdit.getInstance().getMemory().initCopiedMemory(player);
                        maker.sendForm(FormMaker.copy);
                        break;

                    case 2:
                        if (SignEdit.getInstance().getMemory().hasCopiedMemory(player)) {
                            maker.sendForm(FormMaker.paste);
                        } else {
                            player.sendMessage("> 貼り付けられる文字がありません");
                        }
                        break;

                    case 3:
                        maker.sendForm(FormMaker.clear);
                        break;

                    case 4:
                        if (SignEdit.getInstance().getMemory().hasCopiedMemory(player)) {
                            maker.sendForm(FormMaker.delete);
                        } else {
                            player.sendMessage("> 消せる文字がありません");
                        }
                        break;
                }
            }
        };

        form.setId(FormMaker.formCount++);
        form.setTitle("TOP");
        form.setContent("実行する処理を選択してください");

        Button edit = new Button().setText("書き換え").setImage("url", "https://i.imgur.com/QmA6UZR.png");
        Button copy = new Button().setText("コピー").setImage("url", "https://i.imgur.com/vGXIZhS.png");
        Button paste = new Button().setText("ペースト").setImage("url", "https://i.imgur.com/hA4v71w.png");
        Button clear = new Button().setText("全削除").setImage("url", "https://i.imgur.com/4hBz3Ij.png");
        Button delete = new Button().setText("キャッシュ削除").setImage("url", "https://i.imgur.com/n8W4leS.png");

        form.addButton(edit);
        form.addButton(copy);
        form.addButton(paste);
        form.addButton(clear);
        form.addButton(delete);

        return form;
    }
}
