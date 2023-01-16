package net.runelite.client.plugins.WildernessClanCallouts.src.main.java.com.WildernessClanCallouts;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("net/runelite/client/plugins/PreTypeEnemyName/src/PreTypeEnemyName")
public interface WildernessClanCalloutsConfig extends Config
{
	@ConfigItem(
			keyName = "messagePrefix",
			name = "Message prefix",
			description = "The prefix to add before the enemy's name"
	)
	default String messagePrefix()
	{
		return "syn";
	}
	@ConfigItem(
			keyName = "hotKey",
			name = "Hotkey",
			description = "The hotkey to press in order to type and submit the message"
	)
	default Keybind hotKey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
			keyName = "shortenName",
			name = "Shorten Name",
			description = "Shorten the enemy's name to 3 characters long"
	)
	default boolean shortenName()
	{
		return false;
	}
}
