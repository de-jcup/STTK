# STTK
STTK - Security Threatmodel Toolkit

## In a nutshell


With STTK developers, architects and also security exports shall be able to define a textual based model contain meta
data about

- system (c4 model: system context, container, components etc.)
- technology
- threat model (stride)


## Technology
### Model
This is java based - see `src/test/java/de/jcup/sttk/example/ExampleModel1.java` so its very easy to define own
models.

So when a technology changes or something is added to the system which is security relevant, developers can easily
add or update the simple model.

### Output
When model has been designed, we generate the output by using generators.

See `src/test/java/de/jcup/sttk/example/GenerateExample1TestMain.java`

We generate output in following formats

- [asciidoctor](https://https://asciidoctor.org)
- [plantuml](https://www.plantuml.com) 

You are able to show up output by dedicated editors, e.g. [Eclipse Asciidoctor Editor](https://marketplace.eclipse.org/content/asciidoctor-editor) which is able to provide WYSIWYG for asciidoc and plantuml.

## Development

### Import project
#### Eclipse
Please do
`./gradlew cleanEclipse eclipse` from repository root on your terminal.
After gradle tasks has been done, just import project as existing one into eclipse and you are done.

Or you can try to import as gradle project (but first described variant will always work)

#### Other IDEs
Try to import as gradle project.