package kr.hwanik.get.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by hwanik on 2017. 2. 23..
 */

public class Util {
    public static Drawable resizeImage(Context ctx, int resId, int iconWidth, int iconHeight) {

        // load the origial Bitmap
        Bitmap BitmapOrg = BitmapFactory.decodeResource(ctx.getResources(), resId);

        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();

        // calculate the scale
        float scaleWidth = ((float) iconWidth) / width;
        float scaleHeight = ((float) iconHeight) / height;

        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the Bitmap
        matrix.postScale(scaleWidth, scaleHeight);

        // if you want to rotate the Bitmap
        // matrix.postRotate(45);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width, height, matrix, true);

        // make a Drawable from Bitmap to allow to set the Bitmap
        // to the ImageView, ImageButton or what ever
        return new BitmapDrawable(resizedBitmap);
    }
}
