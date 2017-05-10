package training.com.niccage.movies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import training.com.niccage.R;
import training.com.niccage.rest.NicCageAPI;
import training.com.niccage.rest.model.SimilarMovies;


public class SimilarMoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_movies);

        final int movieId = getIntent().getExtras().getInt("movieId");



        NicCageAPI.API.getSimilarMovies(movieId).enqueue(new Callback<SimilarMovies>() {
            @Override
            public void onResponse(Call<SimilarMovies> call, Response<SimilarMovies> response) {
                Toast.makeText(SimilarMoviesActivity.this, response.body().getTotalPages()+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SimilarMovies> call, Throwable t) {

            }
        });
    }
}