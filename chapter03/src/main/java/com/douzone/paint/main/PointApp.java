package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class PointApp {
	public static void main(String[] args) {
		
		Point point1 = new Point(10, 20);
		point1.draw();
		point1.show(false);
		
		Point point2 = new Point(100, 200);
		point2.draw();
		// point2.show();
		//drawPoint(point2);
		draw(point2);

		Point point3 = new ColorPoint(50, 100, "red");
		// point3.show();
		point3.show(true);
		// point3.show(true);
		draw(point3);

		Rect rect = new Rect();
		// drawRect(rect);
		draw(rect);

		Triangle triangle = new Triangle();
		// drawTriangle(triangle);
		draw(triangle);

		Circle circle = new Circle();
		//drawShape(circle);
		draw(circle);
		
		
		draw(new GraphicText("hello"));
		//instenceof test
		
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		
		//오류 ; class hierachy 상위 하위만 instanceof 연산자를 사용할 수 있다.
		//System.out.println(circle instanceof Triangle);
		
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
		//인터페이스는 hierachy와 상관없이 instanceof 연산자를 사용할 수 있다.
		
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);
		
		
		
	}
	public static void draw(Drawable drawable) {
		drawable.draw();
	}

//	public static void drawColorPoint(ColorPoint pt) {
//		pt.show();
//	}

/*	public static void drawPoint(Point pt) {
		pt.show();
	}

	public static void drawShape(Shape shape) {
		shape.draw();
	}

//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
*/
}
