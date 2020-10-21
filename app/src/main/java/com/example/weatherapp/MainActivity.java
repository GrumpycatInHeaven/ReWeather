package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.data.Channel;
import com.example.weatherapp.data.Condition;
import com.example.weatherapp.data.Item;
import com.example.weatherapp.data.Units;
import com.example.weatherapp.service.WeatherServiceCallback;
import com.example.weatherapp.service.YahooWeatherService;


public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView iconWeather;
    private TextView temperature;
    private TextView condition;
    private TextView location;
    private TextView date;
    private TextView pressure;
    private TextView speed;
    private TextView humidity;
    private TextView sunrise;
    private TextView sunset;
    private long INTERVAL_DAY;

    private YahooWeatherService service;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (TextView) findViewById(R.id.updateText);
        pressure = (TextView) findViewById(R.id.pressureText);
        speed = (TextView) findViewById(R.id.windText);
        humidity = (TextView) findViewById(R.id.humidText);
        sunrise = (TextView) findViewById(R.id.riseText);
        sunset = (TextView) findViewById(R.id.setText);
        iconWeather = (ImageView) findViewById(R.id.WeatherIcon);
        temperature = (TextView) findViewById(R.id.tempText);
        condition = (TextView) findViewById(R.id.conditionText);
        location = (TextView) findViewById(R.id.cityText);


        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service = new YahooWeatherService(this);
        service.refreshWeather("Sochi, RU");

    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();


        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().
                getCode(), null, getPackageName());

        // Get weather status and find corresponding icon
        Drawable iconWeatherDrawable = getResources().getDrawable(resourceId);

        // Setting image
        iconWeather.setImageDrawable(iconWeatherDrawable);

        String s = String.valueOf(item.getCondition().getDescription());

        // If it's cloudy now you will receive a notification
        if (s.equals("Cloudy")) {


            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            // Description of notification
            Notification.Builder builder = new Notification.Builder(this)
                    .setTicker("Прогноз!")
                    .setContentTitle("(∩` ﾛ ´)⊃━炎炎炎炎炎 ")
                    .setContentText(
                            "Сегодня ветренно и.....")
                    .setSmallIcon(R.drawable.icon_26)
                    .addAction(R.drawable.icon_26, "Запустить приложение",
                            pendingIntent).setAutoCancel(true);


            String bigText = "Сегодня ветренно, следует"
                    + "одеться теплее и взять с собой шапку ヽ(”`▽´)ﾉ";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(1, notification);
        }

        // It's and next like a previous instead title, icon and text of notification
        if (s.equals("Mostly Cloudy")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setTicker("Прогноз!")
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle("(∩` ﾛ ´)⊃━炎炎炎炎炎 ")
                    .setContentText(
                            "Сегодня ветренно и.....")
                    .setSmallIcon(R.drawable.icon_29)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_29, "Запустить приложение",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Сегодня ветренно, следует"
                    + "одеться теплее и взять с собой шапку ヽ(”`▽´)ﾉ";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(4, notification);
        }


        if (s.equals("Thunderstorms")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setTicker("Прогноз!")
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle("(＃￣□￣)o━∈・・━━━━☆")
                    .setContentText(
                            "Сегодня лучше всего взять: ")
                    .setSmallIcon(R.drawable.icon_2)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_2, "Запустить активность",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Сегодня грозы, следует"
                    + " держаться сухим и держаться подальше от открытой местности, воды, " +
                    "металлических предеметов, а также очень опасно разоваривать по телефону └(- -)┐";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            notificationManager.notify(2, notification);
        }


        if (s.equals("Tornado")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("Прогноз!")
                    .setContentTitle("(╯°□°)╯︵ ┻━┻")
                    .setContentText("Надевайте все, что хотите, но для начала:" +
                            "1. Плотно закройте двери, окна, балконную дверь, " +
                            "форточку и вентиляционные отверстия. Если есть время – укрепите крышу," +
                            " освободите балкон он пожароопасных предметов.\n" +
                            "2. Отключите электробытовые приборы, газ.\n" +
                            "3. Если у вас в доме есть подвал или погреб: " +
                            "возьмите с собой необходимые вещи " +
                            "(документы, воду, фонарик, медикаменты) и укройтесь там.\n" +
                            "4. Если у вас нет подвала, оставайтесь в доме, " +
                            "желательно - во внутренних комнатах или в ванной. " +
                            "Не приближайтесь к окнам, относительно безлопастные места – " +
                            "дверной проем, коридор, кладовка. \n ")
                    .setSmallIcon(R.drawable.icon_0)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_0, "Запустить активность",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Надевайте все, что хотите, но для начала:" +
                    "1. Плотно закройте двери, окна, балконную дверь, форточку и вентиляционные " +
                    "отверстия. Если есть время – укрепите крышу, " +
                    "освободите балкон он пожароопасных предметов.\n" +
                    "2. Отключите электробытовые приборы, газ.\n" +
                    "3. Если у вас в доме есть подвал или погреб: возьмите с собой необходимые " +
                    "вещи (документы, воду, фонарик, медикаменты) и укройтесь там.\n" +
                    "4. Если у вас нет подвала, оставайтесь в доме, желательно - во внутренних " +
                    "комнатах или в ванной. Не приближайтесь к окнам, относительно безлопастные " +
                    "места –  дверной проем, коридор, кладовка. \n ";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(3, notification);
        }


        if (s.equals("Scattered Showers")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("Прогноз!")
                    .setContentTitle("(ノ ˘_˘)ノ　ζ|||ζ")
                    .setContentText(
                            "Сегодня лучше всего взять: ")
                    .setSmallIcon(R.drawable.icon_38)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_111, "Запустить активность",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Сегодня моросящие дожди,"
                    + " следует взять с собой зонтик☁";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(5, notification);
        }


        if (s.equals("Showers")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("Прогноз!")
                    .setContentTitle("(ノ ˘_˘)ノ　ζ|||ζ　ζ|||ζ　ζ|||ζ")
                    .setContentText(
                            "Сегодня лучше всего взять: ")
                    .setSmallIcon(R.drawable.icon_12)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_122, "Запустить активность",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Сегодня ливни,"
                    + " обязательно возьмите с собой зонтик☁";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(6, notification);
        }


        if (s.equals("Windy")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("Прогноз!")
                    .setContentTitle("(ﾉ-.-)ﾉ.….(((((((((((")
                    .setContentText(
                            "Сегодня лучше всего взять: ")
                    .setSmallIcon(R.drawable.icon_24)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_244, "Запустить активность",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Сегодня ветренно,"
                    + " не забудьте взять с собой шарф и шапку. " +
                    "Внимательней смотрите по сторонам ┬┴┬┴┤(･_├┬┴┬┴";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(7, notification);
        }


        if (s.equals("Sunny")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                     intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("Прогноз!")
                    .setContentTitle("٩(◕‿◕｡)۶")
                    .setContentText(
                            "Сегодня лучше всего взять: ")
                    .setSmallIcon(R.drawable.icon_32)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_32, "Запустить активность",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Сегодня солнечно,"
                    + " рекомендую взять с собой солнечные очки и на всякий случай крем от" +
                    " загара(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(8, notification);
        }


        if (s.equals("Blustery")) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("Прогноз!")
                    .setContentTitle("(∩ᄑ_ᄑ)⊃━☆≡≡≡≡≡≡≡≡≡≡")
                    .setContentText(
                            "Сегодня лучше всего взять: ")
                    .setSmallIcon(R.drawable.icon_23)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .addAction(R.drawable.icon_23, "Запустить активность",
                            pendingIntent).setAutoCancel(true);

            String bigText = "Сегодня прогнозируется буря,"
                    + " выходя из дома, не забудьте взять с собой шарф(можно два) и шапку." +
                    " Внимательней смотрите по сторонам, не находитесь под ненадежными" +
                    " объектами(деревья и т.п.) ┬┴┬┴┤･-･)ﾉ";

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(9, notification);
        }

        // Setting values of each parameter
        humidity.setText(String.format("Humidity: %s%%", channel.getAtmosphere().getHumidity()));
        pressure.setText(String.format("Pressure: %smb", channel.getAtmosphere().getPressure()));

        speed.setText(String.format("Speed: %d %s", channel.getWind().getSpeed(),
                channel.getUnits().getSpeed()));
        sunrise.setText(String.format("Sunrise: %s", channel.getAstronomy().getSunrise()));
        sunset.setText(String.format("Sunset: %s", channel.getAstronomy().getSunset()));

        date.setText(item.getCondition().getDate());
        temperature.setText(String.format("%d°%s", item.getCondition().getTemperature(),
                channel.getUnits().getTemperature()));
        condition.setText(item.getCondition().getDescription());
        location.setText(service.getLocation());
    }


    @Override
    public void serviceFailure(Exception e) {
        dialog.hide();
        // Get error's description
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}