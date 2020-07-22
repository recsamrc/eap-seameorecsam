package mad.eapseameorecsam.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;


import mad.eapseameorecsam.R;
import mad.eapseameorecsam.models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Intent intent = getIntent();
        if (intent != null) {
            int productId = intent.getIntExtra("index", 0);
            loadProduct(productId);
        }

    }

    private void loadProduct(final int index) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://ite-rupp.ap-southeast-1.elasticbeanstalk.com/products.php";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                product = gson.fromJson(response, Product[].class)[index];
                updateUI();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ProductDetail: ", "onError: " + error);
            }
        });
        queue.add(request);
    }

    private void updateUI() {
        SimpleDraweeView img = findViewById(R.id.img);
        TextView name = findViewById(R.id.product_name);
        TextView code = findViewById(R.id.txt_code);
        TextView description = findViewById(R.id.txt_desc);
        TextView price = findViewById(R.id.txt_price);
        TextView totalRate = findViewById(R.id.total_rate);
        TextView averageRate = findViewById(R.id.average_rate);
        TextView views = findViewById(R.id.views);

        img.setImageURI(Uri.parse(product.getImageUrl()));
        name.setText(product.getName());
        code.setText(product.getCode());
        description.setText(product.getDescription());
        price.setText("" + product.getPrice() + "$");
        totalRate.setText("( " + product.getTotalRate() + " in total )");
        averageRate.setText("" +product.getAverageRate());
        views.setText("" + product.getTotalView() + " views");
    }

}