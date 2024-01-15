package org.example.util;

public class CalcDistance {

        private static final double EARTH_RADIUS = 6371; // Radio de la Tierra en kilómetros

        public double calcDistance(double lat1, double long1, double lat2, double long2) {
            // Convertir las coordenadas a radianes
            double latRadians1 = Math.toRadians(lat1);
            double longRadians1 = Math.toRadians(long1);
            double latRadians2 = Math.toRadians(lat2);
            double longRadians2 = Math.toRadians(long2);

            // Calcular la diferencia entre las latitudes y longitudes
            double diffLats = latRadians2 - latRadians1;
            double diffLongs = longRadians2 - longRadians1;

            // Aplicar la fórmula de Haversine
            double a = Math.pow(Math.sin(diffLats / 2), 2) +
                    Math.cos(latRadians1) * Math.cos(latRadians2) *
                            Math.pow(Math.sin(diffLongs / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = EARTH_RADIUS * c;

            return distance;

        }
}
