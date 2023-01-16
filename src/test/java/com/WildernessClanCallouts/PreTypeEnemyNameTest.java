package net.runelite.client.plugins.WildernessClanCallouts.src.test.java.com.WildernessClanCallouts;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.plugins.WildernessClanCallouts.src.main.java.com.WildernessClanCallouts.WildernessClanCalloutsPlugin;


public class PreTypeEnemyNameTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(WildernessClanCalloutsPlugin.class);
		RuneLite.main(args);
	}
}