package edu.mum.mobile.store.dao;

import edu.mum.mobile.store.bean.ProductDetail;

public class ProductDetailDao {
    public ProductDetail getProductDetail(int productId) {
        ProductDetail pd = null;
        switch (productId) {
            case 1: // Iphone X
                pd = new ProductDetail("Hexa-core 2.39 GHz (2x Monsoon + 4x Mistral)",
                        "64/256 GB, 3 GB RAM",
                        "Dual: 12 MP (f/1.8, 28mm) + 12 MP (f/2.4, 52mm)",
                        "Vibration, proprietary ringtones",
                        "Non-removable Li-Ion 2716 mAh battery (10.35 Wh)",
                        "iOS 11.1.1",
                        "Super AMOLED capacitive touchscreen, 16M colors",
                        "Available. Released 2017, October"
                );
                break;
            case 2://Iphone 8
                pd = new ProductDetail("Hexa-core (2x Monsoon + 4x Mistral)",
                        "64/256 GB, 2 GB RAM",
                        "12 MP (f/1.8, 28mm), phase detection autofocus",
                        "VVibration, proprietary ringtones",
                        "Non-removable Li-Ion 1821 mAh battery (6.96 Wh)",
                        "iOS 11, upgradable to iOS 11.2",
                        "LED-backlit IPS LCD, capacitive touchscreen, 16M colors",
                        "Available. Released 2017, September"
                );
                break;
            case 3://Ipad
                pd = new ProductDetail("Apple A10X Fusion",
                        "64/256/512 GB, 4GB RAM",
                        "12 MP (f/1.8, 1/3\"), phase detection autofocus",
                        "Vibration; Ringtones",
                        "Non-removable Li-Ion battery (41 Wh)",
                        "iOS 10.3.2, upgradable to iOS 11.2",
                        "SLED-backlit IPS LCD, capacitive touchscreen, 16M colors",
                        "Available. Released 2017, June"
                );
                break;
            case 4://apple watch series 3
                pd = new ProductDetail("Apple S3",
                        "16 GB, 768 MB RAM (to be confirmed)",
                        "No Camera",
                        "Vibration; Ringtones",
                        "Non-removable Li-Ion 279 mAh battery (1.07 Wh)",
                        "watchOS 4.0, upgradable to 4.1",
                        "AMOLED capacitive touchscreen, 16M colors",
                        "Available. Released 2017, September"
                );
                break;
            case 9://Iphone 7
                pd = new ProductDetail("Quad-core 2.34 GHz (2x Hurricane + 2x Zephyr)",
                        "32/128/256 GB, GB, 2 GB RAM",
                        "12 MP (f/1.8, 28mm, 1/3\"), phase detection autofocus",
                        "\tVibration, proprietary ringtones",
                        "Non-removable Li-Ion 1960 mAh battery (7.45 Wh)",
                        "\tiOS 10.0.1, upgradable to iOS 11.2",
                        "LED-backlit IPS LCD, capacitive touchscreen, 16M colors",
                        "Available. Released 2016, September"
                );
                break;
            case 10://Samsung s8
                pd = new ProductDetail("cta-core (4x2.3 GHz & 4x1.7 GHz) - EMEA",
                        "64 GB, 4 GB RAM",
                        "12 MP (f/1.7, 26mm, 1/2.5\", 1.4 µm, Dual Pixel PDAF)",
                        "Vibration; MP3, WAV ringtones",
                        "Non-removable Li-Ion 3000 mAh battery",
                        "Android 7.0 (Nougat)",
                        "5.8 inches, 84.8 cm2 (~83.6% screen-to-body ratio)",
                        "Available. Released 2017, April"
                );
                break;
            case 11://iphone 6
                pd = new ProductDetail("Dual-core 1.4 GHz Typhoon (ARM v8-based)",
                        "16/32/64/128 GB, 1 GB RAM DDR3",
                        "8 MP (f/2.2, 29mm, 1/3\", 1.5 µm), phase detection autofocus",
                        "Vibration, proprietary ringtones",
                        "Non-removable Li-Po 1810 mAh battery (6.9 Wh)",
                        "iOS 8, upgradable to iOS 11.2",
                        "4.7 inches, 60.9 cm2 (~65.8% screen-to-body ratio)",
                        "Available. Released 2014, September"
                );
                break;
            case 12://iphone 5
                pd = new ProductDetail("Dual-core 1.3 GHz Swift (ARM v7-based)",
                        "16/32/64 GB, 1 GB RAM DDR2",
                        "8 MP (f/2.4, 33mm, 1/3.2\", 1.4 µm), autofocus",
                        "Vibration, proprietary ringtones",
                        "Non-removable Li-Po 1440 mAh battery (5.45 Wh)",
                        "iOS 6, upgradable to iOS 10.3.3",
                        "4.0 inches, 44.1 cm2 (~60.8% screen-to-body ratio)",
                        "Available. Released 2012, September"
                );
                break;
            case 13://J7 prime
                pd = new ProductDetail("Octa-core 1.6 GHz Cortex-A53",
                        "16/32 GB, 3 GB RAM",
                        "13 MP (f/1.9, 28mm), autofocus, LED flash",
                        "Vibration; MP3, WAV ringtones",
                        "Non-removable Li-Ion 3300 mAh battery",
                        "Android 6.0.1 (Marshmallow), upgradable to 7.0 (Nougat)",
                        "5.5 inches, 83.4 cm2 (~73.3% screen-to-body ratio)",
                        "Available. Released 2016, September"
                );
                break;
            case 14://note 7
                pd = new ProductDetail("Octa-core (4x2.3 GHz Mongoose & 4x1.6 GHz Cortex-A53)",
                        "64 GB, 4 GB RAM",
                        "12 MP (f/1.7, 26mm, 1/2.5\", 1.4 µm, Dual Pixel PDAF)",
                        "Vibration; MP3, WAV ringtones",
                        "Non-removable Li-Ion 3500 mAh battery",
                        "Android 6.0.1 (Marshmallow)",
                        "5.7 inches, 88.5 cm2 (~78.0% screen-to-body ratio)",
                        "Released 2016, September"
                );
                break;
            case 15://note fe
                pd = new ProductDetail("Octa-core (4x2.3 GHz Mongoose & 4x1.6 GHz Cortex-A53)",
                        "64 GB, 4 GB RAM",
                        "12 MP (f/1.7, 26mm, 1/2.5\", 1.4 µm, Dual Pixel PDAF)",
                        "Vibration; MP3, WAV ringtones",
                        "Non-removable Li-Ion 3200 mAh battery",
                        "Android 7.1.1 (Nougat)",
                        "5.7 inches, 89.6 cm2 (~79.0% screen-to-body ratio)",
                        "Available. Released 2017, July"
                );
                break;
            case 16://j7 max
                pd = new ProductDetail("Octa-core 2.4 GHz Cortex-A53",
                        "32 GB, 4 GB RAM",
                        "13 MP, f/1.7, autofocus, LED flash",
                        "Vibration; MP3, WAV ringtones",
                        "Non-removable Li-Ion 3300 mAh battery",
                        "Android 7.0 (Nougat)",
                        "5.7 inches, 89.6 cm2 (~72.5% screen-to-body ratio)",
                        "Available. Released 2017, June"
                );
                break;
            case 17://google pixel
                pd = new ProductDetail("Quad-core (2x2.15 GHz Kryo & 2x1.6 GHz Kryo)",
                        "32/128 GB, 4 GB RAM",
                        "12.3 MP (f/2.0, 1/2.3, 1.55 µm), gyro EIS",
                        "Vibration; MP3, WAV ringtones",
                        "Non-removable Li-Ion 2770 mAh battery",
                        "Android 7.1 (Nougat), upgradable to Android 8.0 (Oreo)",
                        "5.0 inches, 68.9 cm2 (~69.0% screen-to-body ratio)",
                        "Available. Released 2016, October"
                );
                break;
            case 18://google pixel 2
                pd = new ProductDetail("Octa-core (4x2.35 GHz Kryo & 4x1.9 GHz Kryo)",
                        "64/128 GB, 4 GB RAM",
                        "12.2 MP (f/1.8, 27mm, 1/2.6\", 1.4 µm, Dual Pixel PDAF)",
                        "Vibration; MP3, WAV ringtones",
                        "Non-removable Li-Ion 2700 mAh battery",
                        "Android 8.0",
                        "5.0 inches, 68.9 cm2 (~67.9% screen-to-body ratio)",
                        "Available. Released 2017, October"
                );
                break;
             default:
                 pd = new ProductDetail("Hexa-core 2.39 GHz (2x Monsoon + 4x Mistral)",
                         "64/256 GB, 3 GB RAM",
                         "Dual: 12 MP (f/1.8, 28mm) + 12 MP (f/2.4, 52mm)",
                         "Vibration, proprietary ringtones",
                         "Non-removable Li-Ion 2716 mAh battery (10.35 Wh)",
                         "iOS 11.1.1",
                         "Super AMOLED capacitive touchscreen, 16M colors",
                         "Available. Released 2017, October"
                 );
                 break;

        }
        return pd;
    }
}
