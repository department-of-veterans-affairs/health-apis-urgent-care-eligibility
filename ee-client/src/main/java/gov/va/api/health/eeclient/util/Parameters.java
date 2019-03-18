package gov.va.api.health.eeclient.util;

import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/** A cleaner parameter map builder based on Spring' MultiValueMap. */
@SuppressWarnings("UnusedReturnValue")
@NoArgsConstructor(staticName = "builder")
public class Parameters {

  private final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

  /** Create an empty, immutable map. */
  public static MultiValueMap<String, String> empty() {
    return builder().build();
  }

  /** Add a single key/value entry. */
  public Parameters add(String key, String value) {
    params.add(key, value);
    return this;
  }

  /** Add a repeated key/value entry, where multiple values are associated to the given key. */
  public Parameters addAll(String key, List<String> values) {
    params.addAll(key, values);
    return this;
  }

  /** Create an immutable map. */
  public MultiValueMap<String, String> build() {
    return CollectionUtils.unmodifiableMultiValueMap(params);
  }
}
