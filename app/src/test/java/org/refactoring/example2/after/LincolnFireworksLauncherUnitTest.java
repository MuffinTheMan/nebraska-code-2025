package org.refactoring.example2.after;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertAll;

class LincolnFireworksLauncherUnitTest {
    @ParameterizedTest
    @ValueSource(ints = {2020, 2021, 2022, 2023, 2024, 2025, 2026})
    void launch(int year) {
        assertAll(
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 3, 7, 59));
                launcher.launch();
                launcher.launch();
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isZero();
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 3, 8, 0));
                assertThat(launcher.getLaunchCounter()).isZero();
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 3, 8, 0));
                launcher.launch();
                launcher.launch();
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isEqualTo(3);
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 3, 8, 1));
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isEqualTo(1);
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 3, 23, 0));
                launcher.launch();
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isEqualTo(2);
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 3, 23, 1));
                launcher.launch();
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isZero();
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 4, 7, 59));
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isZero();
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 4, 8, 0));
                assertThat(launcher.getLaunchCounter()).isZero();
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 4, 8, 0));
                launcher.launch();
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isEqualTo(2);
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 4, 8, 1));
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isEqualTo(1);
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 4, 23, 59));
                launcher.launch();
                launcher.launch();
                launcher.launch();
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isEqualTo(4);
            },
            () -> {
                LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, 5, 0, 0));
                launcher.launch();
                launcher.launch();
                assertThat(launcher.getLaunchCounter()).isZero();
            },
            () -> {
                List<Executable> executables = new ArrayList<>();
                IntStream.rangeClosed(1, 12).forEach(month -> {
                    if (month != 7) { // Skip July
                        LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, month, 4, 12, 0));
                        executables.add(() -> {
                            launcher.launch();
                            launcher.launch();
                            assertThat(launcher.getLaunchCounter()).isZero();
                        });
                    }
                });
                IntStream.rangeClosed(1, 31).forEach(day -> {
                    if (day != 3 && day != 4) { // Skip the 3rd and 4th
                        LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, 7, day, 12, 0));
                        executables.add(() -> {
                            launcher.launch();
                            launcher.launch();
                            assertThat(launcher.getLaunchCounter()).isZero();
                        });
                    }
                });
                assertAll(executables);
            }
        );
    }

    @Test
    void currentYear() {
        IntStream.rangeClosed(2020, 2026).forEach(year -> {
            IntStream.rangeClosed(1, 12).forEach(month -> {
                IntStream.rangeClosed(1, 28).forEach(day -> {
                    LincolnFireworksLauncher launcher = new LincolnFireworksLauncher(cstFixedClock(year, month, day, 12, 0));
                    assertThat(launcher.getCurrentYear()).isEqualTo(year);
                });
            });
        });
    }

    @Test
    void noInjection() {
        LincolnFireworksLauncher launcher = new LincolnFireworksLauncher();
        assertAll(
            () -> assertThat(launcher.getCurrentYear()).isEqualTo(LocalDateTime.now(LincolnFireworksLauncher.CST).getYear()),
            () -> assertThat(launcher.getClock().getZone()).isEqualTo(LincolnFireworksLauncher.CST),
            () -> assertThat(launcher.getClock().instant().getEpochSecond()).isCloseTo(Instant.now().atZone(LincolnFireworksLauncher.CST).toInstant().getEpochSecond(), within(1L))
        );

    }

    private static Clock cstFixedClock(int year, int month, int day, int hour, int minute) {
        return Clock.fixed(LocalDateTime.of(year, month, day, hour, minute).atZone(LincolnFireworksLauncher.CST).toInstant(), LincolnFireworksLauncher.CST);
    }
}
