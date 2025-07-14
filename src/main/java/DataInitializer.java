    package com.edu.reservas;

    import com.edu.reservas.entity.Asiento;
    import com.edu.reservas.repository.AsientoRepository;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    public class DataInitializer {

        @Bean
        CommandLineRunner initAsientos(AsientoRepository asientoRepository) {
            return args -> {
                if (asientoRepository.count() == 0) {
                    asientoRepository.save(new Asiento(null, "A1", false));
                    asientoRepository.save(new Asiento(null, "A2", false));
                    asientoRepository.save(new Asiento(null, "A3", false));
                    asientoRepository.save(new Asiento(null, "A4", false));
                    asientoRepository.save(new Asiento(null, "A5", false));
                    asientoRepository.save(new Asiento(null, "A6", false));
                    asientoRepository.save(new Asiento(null, "A7", false));
                    asientoRepository.save(new Asiento(null, "A8", false));
                    asientoRepository.save(new Asiento(null, "A9", false));
                    asientoRepository.save(new Asiento(null, "B1", false));
                    asientoRepository.save(new Asiento(null, "B2", false));
                    asientoRepository.save(new Asiento(null, "B3", false));
                    asientoRepository.save(new Asiento(null, "B4", false));
                    asientoRepository.save(new Asiento(null, "B5", false));
                    asientoRepository.save(new Asiento(null, "B6", false));
                    asientoRepository.save(new Asiento(null, "B7", false));
                    asientoRepository.save(new Asiento(null, "B8", false));
                    asientoRepository.save(new Asiento(null, "B9", false));

                }
            };
        }
    }
