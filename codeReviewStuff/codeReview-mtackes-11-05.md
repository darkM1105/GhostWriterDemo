### Team Day's Code Review Checklist

Review by Michael Tackes  
November 5, 2015 ([point-in-time snapshot](https://github.com/darkM1105/GhostWriterDemo/tree/ac495f99b97d7ea5618c67aedfa44cc4e0e017eb))

### Project Structure
| Metric | Measurement | Notes |
| :---------- | :----------: | :---------- |
| Classes are single-purpose | Some | Demo is a little busy, but it was intended as a quick hack to show something working. |
| Proper file structure | No | There's very little code, but what there is has no package structure. |
| Proper implementation of industry-standard high-level structure (or, appropriate separation of concerns) | Poor | Demo is doing to much, though I'm not familiar with Swing. |

### Code Structure and Style
| Metric | Measurement | Notes |
| :---------- | :----------: | :---------- |
| No duplicate code | Yes |  |
| No dead/useless/lazy/unreachable code | Yes | One very minor unused property in demo (`static final String nl`). |
| Variables and methods have appropriate access modifiers | Yes |  |
| No hardcoded variables/magic numbers/strings | Yes |  |
| Readability | Good | I'm not super clear on some of `Demo`, but that's mostly Swing's fault. |
| Full, complete Javadoc for all classes and methods | None |  |
| Appropriate and descriptive variable and function names | Good |  |
| Consistent formatting | Yes |  |
| Methods are concise and single-purpose | Most | Again, this is tough for me to tell for sure with the Swing stuff in there. |
| Class constructors are present and appropriately implemented | All |  |

### Testing
| Metric | Measurement | Notes |
| :---------- | :----------: | :---------- |
| Code compiles with no errors or warnings | Yes | Compiles and runs, but doesn't function properly. |
| Appropriate use of logging | Poor |  |
| No System.out.println use | Yes | |
| Testing for positive results | No | |
| Testing for negative resuts | No | |
| Testing for errors and exceptions | No | |
| Code coverage with tests | None |  |
