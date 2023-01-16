package net.runelite.client.plugins.WildernessClanCallouts.src.main.java.com.WildernessClanCallouts;

import com.google.inject.Provides;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.HotkeyListener;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.awt.event.KeyEvent;



@PluginDescriptor(name = "Wilderness Clan Callouts", enabledByDefault=true)
@Singleton
public class WildernessClanCalloutsPlugin extends Plugin
{

	@Inject
	@Nullable
	private Client client;

	@Inject
	private WildernessClanCalloutsConfig config;

	@Inject
	private KeyManager keyManager;

	private HotkeyListener hotkeyListener;
	private AWTKeyStroke hotKey;

	public WildernessClanCalloutsPlugin() {
	}

	@Override
	protected void startUp()
	{
		hotkeyListener = new HotkeyListener(config::hotKey)

		{
			@Override
			public void hotkeyPressed()
			{
				Actor interacting = client.getLocalPlayer().getInteracting();
				if (interacting != null && interacting.getName() != null)
				{
					typeActorName(interacting);
				}
			}
		};

		keyManager.registerKeyListener(hotkeyListener);
	}

	@Override
	protected void shutDown()
	{
		keyManager.unregisterKeyListener(hotkeyListener);
	}


	private long lastMessageTime = 0;

	private void typeActorName(Actor actor) {
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastMessageTime > 100) {
			lastMessageTime = currentTime;
			String name = actor.getName();
			if (name != null) {
				if (config.shortenName()) {
					name = name.substring(0, 3);
				}
				String messagePrefix = config.messagePrefix();
				String message = messagePrefix + " " + name;
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					robot.keyRelease(KeyEvent.VK_ALT);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					for (int i = 0; i < message.length(); i++) {
						char c = message.charAt(i);
						int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
						robot.keyPress(keyCode);
						robot.keyRelease(keyCode);
					}
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);

				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Provides
	WildernessClanCalloutsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WildernessClanCalloutsConfig.class);
	}
}