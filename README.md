# SampleMoxy
Simple example of implementing clean architecture in Android app.
Presentation layer implements MVP with Moxy. 

## Package structure
* domain - inner layer. All business logic goes here. Code in this package is framework independent and can be tested with JUnit
* presentation - presentation layer. Communicates between inner and outer layers. Implements MVP with Moxy library. 
* repository - storage part of outer layer (Android-specific repository)
* ui - UI part of outer layer ()Android views)

## References
### Clean Architecture
https://medium.com/@dmilicic/a-detailed-guide-on-developing-android-apps-using-the-clean-architecture-pattern-d38d71e94029

### Moxy
https://thebrainfiles.wearebrain.com/mvp-for-android-part-2-featuring-moxy-462846218c70
https://habr.com/company/redmadrobot/blog/305798/