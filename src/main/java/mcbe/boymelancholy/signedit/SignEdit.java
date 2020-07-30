package mcbe.boymelancholy.signedit;

import cn.nukkit.plugin.PluginBase;
import itsu.mcbe.form.core.NukkitFormAPI;
import mcbe.boymelancholy.signedit.utils.Memory;

public class SignEdit extends PluginBase {

    public static SignEdit instance;

    private Memory memory;
    private NukkitFormAPI formApi;

    @Override
    public void onEnable() {
        EventListener listener = new EventListener();
        this.getServer().getPluginManager().registerEvents(listener, this);
        instance = this;

        this.memory = new Memory();
        this.formApi = NukkitFormAPI.getSingleton();
    }

    public Memory getMemory() {
        return this.memory;
    }

    public NukkitFormAPI getFormAPI() {
        return this.formApi;
    }

    public static SignEdit getInstance() {
        return instance;
    }
}
