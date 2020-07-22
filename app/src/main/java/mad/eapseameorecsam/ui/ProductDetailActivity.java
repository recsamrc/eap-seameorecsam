package mad.eapseameorecsam.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import mad.eapseameorecsam.R;
import mad.eapseameorecsam.adapters.ProductListAdapter;
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

    }

}