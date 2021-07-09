package io.nozemi.runescape.model.map.steroids;

import java.util.LinkedList;

public class StraightRouteFinder implements RouteFinder {
	
	public static final RouteFinder INSTANCE = new StraightRouteFinder();
	
	private StraightRouteFinder() {
	}
	
	@Override
	public final void path(Route request, int startX, int startY, int plane, int unitSize, LinkedList<Direction> steps) {
		//Pretend we can walk anywhere, steps will be checked when actually taking them
		request.alternative = false;
		int dx = request.targetX - startX;
		int dy = request.targetY - startY;
		while (dx != 0 || dy != 0) {
			Direction next = Direction.orthogonal(dx, dy);
			steps.add(next);
			dx -= next.x;
			dy -= next.y;
		}
	}
	
}
