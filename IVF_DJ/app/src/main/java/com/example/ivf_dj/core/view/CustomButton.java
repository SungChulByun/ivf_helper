package com.example.ivf_dj.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.CustomButtonBinding;

public class CustomButton extends ConstraintLayout {
    private CustomButtonBinding mBinding;
    private TextView textView;
    private ImageView imageView;
    private String buttonName;

    public CustomButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.custom_button, this, true);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.custom_button);
            buttonName = array.getString(R.styleable.custom_button_description);
            array.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView = mBinding.buttonText;
        imageView = mBinding.buttonImage;
        setAlarmCount(0);
        setButtonDetail();

    }

    private Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
//        canvas.drawColor();
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    private void setButtonDetail() {
        switch (buttonName) {
            case "notification":
                textView.setText("전체 공지");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.bell));

                setColor(R.color.beige_deep);
                break;

            case "lecture_list":
                textView.setText("강의 목록");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.book));
                setColor(R.color.brown);
                break;

            case "my_lecture":
                textView.setText("내 강의");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.list));
                setColor(R.color.peach_coral);
                break;

            case "time_table":
                textView.setText("시간표");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.calendar));
                setColor(R.color.sky_blue);
                break;

            case "search":
                textView.setText("수강 신청 현황");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.search));
                setColor(R.color.gold);
                break;

            case "settings":
                textView.setText("설정");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.settings));
                setColor(R.color.not_selected_gray);
                break;

            case "manage_staff":
                textView.setText("스탭 관리");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.staff));
                setColor(R.color.not_selected_gray);
                break;

            default:
                break;

        }
    }

    private void setColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setBackground(new ShapeDrawable(new OvalShape()));
            imageView.getBackground().setTint(getResources().getColor(color));
            imageView.setClipToOutline(true);
        }
    }

    public void setAlarmCount(int count){
        mBinding.setNum(count);
    }

}
