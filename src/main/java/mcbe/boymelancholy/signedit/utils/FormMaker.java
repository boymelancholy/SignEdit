package mcbe.boymelancholy.signedit.utils;

import cn.nukkit.Player;
import itsu.mcbe.form.base.Form;
import mcbe.boymelancholy.signedit.SignEdit;
import mcbe.boymelancholy.signedit.forms.*;

public class FormMaker {

    public final static int call = 0;
    public final static int edit = 1;
    public final static int copy = 2;
    public final static int paste = 3;
    public final static int clear = 4;
    public final static int delete = 5;
    public final static int error = 6;

    public static int formCount = 100;

    private final Player player;

    public FormMaker(Player player) {
        this.player = player;
    }

    public void sendForm(int number) {
        Form form = null;
        switch (number) {
            case call:
                form = (new TopForm()).getForm(this.player);
                break;

            case edit:
                form = (new EditForm()).getForm(this.player);
                break;

            case copy:
                form = (new CopyForm()).getForm(this.player);
                break;

            case paste:
                form = (new PasteForm()).getForm(this.player);
                break;

            case clear:
                form = (new ClearForm()).getForm(this.player);
                break;

            case delete:
                form = (new DeleteForm()).getForm(this.player);
                break;

            case error:
                form = (new CopyExceptionForm()).getForm(this.player);
                break;
        }
        SignEdit.getInstance().getFormAPI().sendFormToPlayer(this.player, form);
    }
}