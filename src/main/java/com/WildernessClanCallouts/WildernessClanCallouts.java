package net.runelite.client.plugins.WildernessClanCallouts.src.main.java.com.WildernessClanCallouts;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class WildernessClanCallouts
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(WildernessClanCalloutsPlugin.class);
		RuneLite.main(args);
	}
}