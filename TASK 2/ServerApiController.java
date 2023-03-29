@RestController
public class ServerApiController implements ServerApi {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public ResponseEntity<List<Server>> getServers() {
        List<Server> servers = serverRepository.findAll();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Server> getServerById(@PathVariable("id") String id) {
        Optional<Server> optionalServer = serverRepository.findById(id);
        if (optionalServer.isPresent()) {
            return new ResponseEntity<>(optionalServer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> createServer(@RequestBody Server server)
