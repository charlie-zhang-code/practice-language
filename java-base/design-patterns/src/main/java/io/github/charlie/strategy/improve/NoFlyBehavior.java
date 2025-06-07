package io.github.charlie.strategy.improve;

public class NoFlyBehavior implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println(" 没有飞行行为  ");
	}

}
