package com.itschool;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
	    double result = 0, x = -1000 /* -1000 ... 1000, 0.1*/,
                           y = -1000 /* -1000 ... 1000, 0.1*/,
                           z = -1000 /* -1000 ... 1000, 0.1*/,
                           a = -2.7, b = 4.1, c = 0.456,
                           x3 = 0, y4 = 0, xc = 0;
        // x^3 + a*y^4 / (b*z^2 + x*c)
        for (x = -1000; x <= 1000; x+=1)
        {
            x3 = x*x*x;
            xc = x * c;
            for (y = -1000; y <= 1000; y+=1)
            {
                y4 = a * y * y * y * y;
                for (z = -1000; z <= 1000; z+=1) {
                    // result = Math.pow(x, 3.0) + a*Math.pow(y, 4.0) / (b*Math.pow(z, 2) + x*c);  // 10700 ms
//            result = x*x*x + a*Math.pow(y, 4.0) / (b*Math.pow(z, 2) + x*c);  // 7350 ms
//            result = x*x*x + a*y*y*y*y / (b*Math.pow(z, 2) + x*c);  // 4200 ms
//            result = x*x*x + a*y*y*y*y / (b*z*z + x*c);  // 6,5 ms
                    // Оптимизация за счёт отказа от вызова функций

                    // увеличили кол-во итераций
//                    result = x * x * x + a * y * y * y * y / (b * z * z + x * c);  // 28.8s
//                    result = x3 + a * y * y * y * y / (b * z * z + x * c);  // 28,8s
//                    result = x3 + a * y4 / (b * z * z + x * c);  // 28,8s
                    result = x3 + y4 / (b * z * z + xc);  // 28,8s
                    // Оптимизация заа счёт чистки циклов
                }
            }
//            System.out.println(x);

        }
        System.out.println(System.nanoTime()-start);

        //System.out.println(result);
    }
}
