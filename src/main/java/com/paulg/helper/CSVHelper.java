package com.paulg.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.paulg.dto.ReporteMontoVendidoDTO;
import com.paulg.dto.ReporteTransacionesTiendaDTO;

public class CSVHelper {

	public static ByteArrayInputStream tutorialsToCSV(List<ReporteTransacionesTiendaDTO> tutorials) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {

			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

			for (ReporteTransacionesTiendaDTO tutorial : tutorials) {
				List<String> data = Arrays.asList(String.valueOf(tutorial.getTransacciones()), tutorial.getTienda(),
						tutorial.getFecha().format(formatter));
				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream montoTotalVendio(List<ReporteMontoVendidoDTO> tutorials) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {

			// DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

			for (ReporteMontoVendidoDTO tutorial : tutorials) {
				List<String> data = Arrays.asList(tutorial.getTienda(), tutorial.getProducto(),
						String.valueOf(tutorial.getTotalmonto()));
				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

}