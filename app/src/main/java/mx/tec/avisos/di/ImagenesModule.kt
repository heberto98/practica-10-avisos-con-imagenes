package mx.tec.avisos.di

import android.content.Context
import coil3.ImageLoader
import coil3.request.crossfade
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImagenesModule {

    /**
     * El que baja y pinta las imágenes, uno para toda la app.
     *
     * Coil usa EL MISMO `OkHttpClient` que Retrofit y el stream: cada imagen sale
     * con `Authorization: Bearer` y, si el token venció, el authenticator lo renueva.
     * Con un cliente propio, Coil pediría las imágenes sin token y el servidor diría 401.
     */
    @Provides
    @Singleton
    fun imageLoader(@ApplicationContext context: Context, cliente: OkHttpClient): ImageLoader =
        ImageLoader.Builder(context)
            .crossfade(true)
            .build()
}
