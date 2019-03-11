package gov.va.api.health.urgentcare.api.bundle;


/*@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://hl7.org/fhir/R4/bundle.html")
public abstract class AbstractBundle<N extends AbstractEntry<?>> implements Resource {
  @NotBlank protected String resourceType;

  @Pattern(regexp = Fhir.ID)
  protected String id;

  @Valid protected Meta meta;

  @Pattern(regexp = Fhir.URI)
  protected String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  protected String language;

  @Valid protected Identifier identifier;

  @NotNull protected BundleType type;

  @Pattern(regexp = Fhir.INSTANT)
  protected String timestamp;

  @Pattern(regexp = Fhir.UNSIGNED_INT)
  protected String total;

  @Valid protected List<BundleLink> link;
  @Valid protected List<N> entry;
  @Valid protected Signature signature;

  @SuppressWarnings("unused")
  public enum BundleType {
    document,
    message,
    transaction,
    @JsonProperty("transaction-response")
    transaction_response,
    batch,
    @JsonProperty("batch-response")
    batch_response,
    history,
    searchset,
    collection
  }
}*/
