# NagisaProject

#DEVELOPMENT-STAGE

## German

Java Schnittstelle für das [VGMDB Project](https://github.com/hufman/vgmdb) von [Hufman](https://github.com/hufman)

## Usage

```java
try {
      VGMdbAlbum album = VGMdb.getAlbum("38626");
      System.out.println("found it!");
    } catch (JsonSyntaxException ex) {
      // developer comment -> debugging at de.knoobie.project.nagisa.gson.model.dto.json.*
      // user comment -> Bug. Need to be fixed.
    } catch (IllegalArgumentException ex) {
      // developer comment -> Simple UserError. Looking for wrong Query/ID
      // user comment -> change the search query/id
    } catch (IOException ex) {
      // developer comment -> vgmdb.info is unavaiable/timeout (2 sec connection, 5 sec read)
      // user comment -> vgmdb.info is unavaiable/timeout
}
```

## Available Requests

```java
VGMdbAlbum album = VGMdb.getAlbum("38626");
VGMdbArtist artist = VGMdb.getArtist("6310");
VGMdbEvent event = VGMdb.getEvent("4");
VGMdbOrganisation org = VGMdb.getOrganisation("1");
VGMdbProduct product = VGMdb.getProduct("1018");
VGMdbSearch searchResult = VGMdb.search("Clannad After Story");
			searchResult.getAlbums();
			searchResult.getArtists();
			searchResult.getOrgs();
			searchResult.getProducts();

```
        
        
