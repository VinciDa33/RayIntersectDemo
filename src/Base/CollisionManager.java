package Base;

import java.util.ArrayList;
import java.util.List;
import Ray.CastTarget;

public class CollisionManager {
    private static CollisionManager instance;

    private List<CastTarget> castTargets = new ArrayList<>();

    //Singleton
    public static CollisionManager getInstance() {
        if (instance == null)
            instance = new CollisionManager();
        return instance;
    }

    private CollisionManager() {};

    public void addCastTarget(CastTarget ct) {
        castTargets.add(ct);
    }

    public void removeCastTarget(CastTarget ct) {
        castTargets.remove(ct);
    }
    public CastTarget getCastTarget(int i) {
        return castTargets.get(i);
    }

    public List<CastTarget> getAllCastTargets() {
        return castTargets;
    }
}
